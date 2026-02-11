
package com.intexus.updateimage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.util.Scanner;

/**
 *
 * @author avillarr
 */
public class Updateimage {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    String fileString1 = args[0];
    File file3 = new File(fileString1);
    byte [] ba2 = new byte [ (int) file3.length() ];
    try (FileInputStream stream3 = new FileInputStream(file3)) {
      stream3.read(ba2);
    } catch (IOException ex) {
      System.out.println("problem reading input");
    }
    String encoded = Base64.getEncoder().encodeToString(ba2);
    StringSelection stringSelection=new StringSelection(encoded);
    Clipboard clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(stringSelection,null);
    System.out.println("CR to end");
    Scanner scanner = new Scanner(System.in);
    String response=scanner.nextLine();
    System.out.println(">>>"+response);
  }
}
