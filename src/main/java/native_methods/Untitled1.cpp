#include <iostream>
#pragma comment(lib, "th32.lib")
#define VC_EXTRALEAN
#include <windows.h>
#include <tlhelp32.h>
#include <stdio.h>
#include <shlwapi.h>
#include <string>

using namespace std;

bool IsPrinterOnline(wstring strPrinterFriendlyName)
{
  HANDLE hPrinter;
  
  if ( OpenPrinter(const_cast<LPWSTR>(strPrinterFriendlyName.c_str()), &hPrinter, NULL) == 0 )
  {    
    // OpenPrinter call failed
    return false;
  }

  DWORD dwBufsize = 0;
  PRINTER_INFO_2* pinfo = 0;
  int nRet = 0;
  nRet = GetPrinter(hPrinter, 2,(LPBYTE)pinfo, dwBufsize, &dwBufsize); //Get dwBufsize
  DWORD dwGetPrinter = 0;
  if (nRet == 0)
  {
    dwGetPrinter = GetLastError(); 
  }

  PRINTER_INFO_2* pinfo2 = (PRINTER_INFO_2*)malloc(dwBufsize); //Allocate with dwBufsize
  nRet = GetPrinter(hPrinter, 2,reinterpret_cast<LPBYTE>(pinfo2), dwBufsize, &dwBufsize);
  if (nRet == 0)
  {
    dwGetPrinter = GetLastError(); 
    return false;
  }

  if (pinfo2->Attributes & PRINTER_ATTRIBUTE_WORK_OFFLINE )
  {
    free(pinfo2); 
    ClosePrinter( hPrinter );
    return false;
  }

  free(pinfo2); 
  ClosePrinter( hPrinter );
  return true;
}

int main() {
	return 0;
}
