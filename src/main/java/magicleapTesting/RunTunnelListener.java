package magicleapTesting;

import org.testng.IExecutionListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunTunnelListener implements IExecutionListener {

    public void onExecutionStart() {

        Thread runTunnel = new Thread(() -> {

            Runtime rt = Runtime.getRuntime();
            String commands = "E:\\project data\\IdeaProjects\\magicleapTesting\\TunnelBinary\\LT.exe --user prateeks --key IuCSesD83A7LsTFzEKS0Lb6tzvEfBQ38DMkFTEpudatxxxsdjH";
            Process proc = null;
            try {
                proc = rt.exec(commands);
            } catch (IOException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(proc.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(proc.getErrorStream()));

// Read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            String s = null;
            try {
                while ((s = stdInput.readLine()) != null) {
                    System.out.println(s);
                }
            } catch (IOException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }

// Read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            try {
                while ((s = stdError.readLine()) != null) {
                    System.out.println(s);
                }
            } catch (IOException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }

        });

        runTunnel.setDaemon(true);
        runTunnel.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void onExecutionFinish() {

        System.out.println("Ending the current session");
    }


}
