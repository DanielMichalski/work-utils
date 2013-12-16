#include <Windows.h>
#include <StdIO.h>


// **********************************************************************
// PrintError - uses printf() to display error code information
// 
// Params:
//   dwError       - the error code, usually from GetLastError()
//   lpString      - some caller-defined text to print with the error info
// 
// Returns: void
// 
void PrintError( DWORD dwError, LPCTSTR lpString )
{
#define MAX_MSG_BUF_SIZE 512
    TCHAR   *msgBuf;
    DWORD   cMsgLen;

    cMsgLen = FormatMessage( FORMAT_MESSAGE_FROM_SYSTEM |
                FORMAT_MESSAGE_ALLOCATE_BUFFER | 40, NULL, dwError,
                MAKELANGID(0, SUBLANG_ENGLISH_US), (LPTSTR) &msgBuf,
                MAX_MSG_BUF_SIZE, NULL );
    printf("%s Error [%d]:: %s\n", lpString, dwError, msgBuf );
    LocalFree( msgBuf );
#undef MAX_MSG_BUF_SIZE
}
// end PrintError
// **********************************************************************

// **********************************************************************
// ReadFileWithAlloc - allocates memory for and reads contents of a file
// 
// Params:
//   szFileName   - NULL terminated string specifying file name
//   pdwSize      - address of variable to receive file bytes size
//   ppBytes      - address of pointer which will be allocated and contain file bytes
// 
// Returns: TRUE for success, FALSE for failure.
//
// Notes: Caller is responsible for freeing the memory using GlobalFree()
// 
BOOL ReadFileWithAlloc( LPTSTR szFileName, LPDWORD pdwSize, LPBYTE *ppBytes )
{
    HANDLE      hFile;
    DWORD       dwBytes;
    BOOL        bSuccess = FALSE;

    // Validate pointer parameters
    if( ( pdwSize == NULL ) || ( ppBytes == NULL ) )
        return FALSE;
    // Open the file for reading
    hFile = CreateFile( szFileName, GENERIC_READ, 0, NULL, OPEN_EXISTING, FILE_ATTRIBUTE_NORMAL, NULL );
    if( hFile == INVALID_HANDLE_VALUE )
    {
        PrintError( GetLastError(), TEXT("CreateFile()") );
        return FALSE;
    }
    // How big is the file?
    *pdwSize = GetFileSize( hFile, NULL );
    if( *pdwSize == (DWORD)-1 )
        PrintError( GetLastError(), TEXT("GetFileSize()") );
    else
    {
        // Allocate the memory
        *ppBytes = (LPBYTE)GlobalAlloc( GPTR, *pdwSize );
        if( *ppBytes == NULL )
            PrintError( GetLastError(), TEXT("Failed to allocate memory\n") );
        else
        {
            // Read the file into the newly allocated memory
            bSuccess = ReadFile( hFile, *ppBytes, *pdwSize, &dwBytes, NULL );
            if( ! bSuccess )
                PrintError( GetLastError(), TEXT("ReadFile()") );
        }
    }
    // Clean up
    CloseHandle( hFile );
    return bSuccess;
}
// End ReadFileWithAlloc
// **********************************************************************

// **********************************************************************
// RawDataToPrinter - sends binary data directly to a printer
// 
// Params:
//   szPrinterName - NULL terminated string specifying printer name
//   lpData        - Pointer to raw data bytes
//   dwCount       - Length of lpData in bytes
// 
// Returns: TRUE for success, FALSE for failure.
// 
BOOL RawDataToPrinter( LPTSTR szPrinterName, LPBYTE lpData, DWORD dwCount )
{
    HANDLE     hPrinter;
    DOC_INFO_1 DocInfo;
    DWORD      dwJob;
    DWORD      dwBytesWritten;

    // Need a handle to the printer.
    if( ! OpenPrinter( szPrinterName, &hPrinter, NULL ) )
    {
        PrintError( GetLastError(), TEXT("OpenPrinter") );
        return FALSE;
    }

    // Fill in the structure with info about this "document."
    DocInfo.pDocName = TEXT("My Document");
    DocInfo.pOutputFile = NULL;
    DocInfo.pDatatype = TEXT("RAW");
    // Inform the spooler the document is beginning.
    if( (dwJob = StartDocPrinter( hPrinter, 1, (LPBYTE)&DocInfo )) == 0 )
    {
        PrintError( GetLastError(), TEXT("StartDocPrinter") );
        ClosePrinter( hPrinter );
        return FALSE;
    }
    // Start a page.
    if( ! StartPagePrinter( hPrinter ) )
    {
        PrintError( GetLastError(), TEXT("StartPagePrinter") );
        EndDocPrinter( hPrinter );
        ClosePrinter( hPrinter );
        return FALSE;
    }
    // Send the data to the printer.
    if( ! WritePrinter( hPrinter, lpData, dwCount, &dwBytesWritten ) )
    {
        PrintError( GetLastError(), TEXT("WritePrinter") );
        EndPagePrinter( hPrinter );
        EndDocPrinter( hPrinter );
        ClosePrinter( hPrinter );
        return FALSE;
    }

    /*********************************/
    // CODE USED TO READ THE PRINTER
    LPBYTE retData = NULL;
    LPDWORD bbr = NULL;

    if(ReadPrinter(hPrinter, retData, 1, bbr))
    {
        printf("OUT : %i", retData);
    }
    else
    {
        printf("Failed to read printer");
    }
    /*********************************/

    // End the page.
    if( ! EndPagePrinter( hPrinter ) )
    {
        PrintError( GetLastError(), TEXT("EndPagePrinter") );
        EndDocPrinter( hPrinter );
        ClosePrinter( hPrinter );
        return FALSE;
    }
    // Inform the spooler that the document is ending.
    if( ! EndDocPrinter( hPrinter ) )
    {
        PrintError( GetLastError(), TEXT("EndDocPrinter") );
        ClosePrinter( hPrinter );
        return FALSE;
    }
    // Tidy up the printer handle.
    ClosePrinter( hPrinter );
    // Check to see if correct number of bytes were written.
    if( dwBytesWritten != dwCount )
    {
        //printf( TEXT("Wrote %d bytes instead of requested %d bytes.\n"), dwBytesWritten, dwCount );
        return FALSE;
    }
    return TRUE;
}
// End RawDataToPrinter
// **********************************************************************

int main( int argc, char* argv[] )
{
    LPBYTE  pBytes = NULL;

    int textSize = 2;

    DWORD   dwSize = textSize;

    pBytes = (LPBYTE) malloc (textSize*sizeof(BYTE));

    pBytes[0] = 0x1B;
    pBytes[1] = 0x6A;


    if( ! RawDataToPrinter("Receipt's printer", pBytes, dwSize) )
        printf("Failed to send data to printer.\n" );
    else
        printf("Data sent to printer.\n" );

    free(pBytes);
    return 0;
}
// end main
// **********************************************************************
