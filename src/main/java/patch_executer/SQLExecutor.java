package patch_executer;

/**
 * Author: Daniel
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SQLExecutor {

    private String directory;
    private String pathPG;
    private String attributePG = " -U pp_user paczkomat_dev <";
    private String lastScript;

    private String fileName = "conf.db";

    SQLExecutor() {
        readData();
        setPassword();

        List<String> list = getFileList();

        int i;
        for (i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            executeScript(directory + File.separator + list.get(i));
        }

        if (i > 0) {
            setLastScript(list.get(list.size() - 1));
        }

        System.out.println("Wykonano " + i + " skryptow SQL...");

        saveData();
    }

    private void setPassword() {
        String[] set = {"cmd.exe", "SET PGPASSWORD=pp_start123!"};
        Runtime r = Runtime.getRuntime();
        try {
            r.exec(set);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private void readData() {
        try {
            File file = new File(fileName);
            @SuppressWarnings("resource")
            Scanner in = new Scanner(file);

            this.directory = in.nextLine();
            this.pathPG = in.nextLine();
            this.lastScript = in.nextLine();
        } catch (FileNotFoundException ex) {
            System.out.println("Nie znaleniono pliku(read): " + fileName);
        }
    }

    private void saveData() {
        try {
            PrintWriter zapis = new PrintWriter(fileName);
            zapis.println(this.directory);
            zapis.println(this.pathPG);
            zapis.println(this.lastScript);
            zapis.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Nie znalezniono pliku(save): " + fileName);
        }
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public List<String> getFileList() {
        File dir = new File(File.separator + directory);
        List<String> temp = Arrays.asList(dir.list());
        List<String> fileList = new ArrayList<String>();

        int i = fileList.indexOf(lastScript);
        if (i < 0) {
            i = 0;
        }

        while (i < temp.size()) {
            fileList.add(temp.get(i));
            i++;
        }

        return fileList;
    }

    public void executeScript(String file) {
        Runtime r = Runtime.getRuntime();
        r.traceInstructions(true);

        String[] cmds = {"\"" + pathPG + "\"", attributePG, "\"" + file + "\""};
        try {
            r.exec(cmds);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void setLastScript(String lastScript) {
        this.lastScript = lastScript;
    }

    public static void main(String args[]) {
        @SuppressWarnings("unused")
        SQLExecutor se = new SQLExecutor();
    }

}
