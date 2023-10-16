package edu.hfcc;

/*
    Part1:  Read in the message.txt file and encode file by subtracting 45 to every byte in the file.
    The encrypted message should be written to a file named message_encrypted.dat.
     This should be done in an encrypt method.

    Part2:  Read and decrypt the file from part1.  Write the decrypted message to a file name message_decrypted.dat.
    This should be done in a decrypt method

    Write unit tests to verify you have  encrypted file correctly and decrypted the file correctly.

    Total Points: 20
    Test Code:  10
    Production Code: 10

 */


import java.io.*;
import java.nio.Buffer;
import java.nio.file.Path;

public class EncryptDecryptFile {

    public static void main(String[] args) {
        encrypt();
        decrypt();
    }

    public static String encrypt() {

        Path path = new PathCreator().createPathToFile("message.txt", "input");
        Path write = new PathCreator().createPathToFile("message_encrypted.dat", "output");
        StringBuilder encrypted = new StringBuilder();

        try (FileInputStream input = new FileInputStream(path.toFile())) {
            try (FileOutputStream output = new FileOutputStream(write.toFile())) {

                int value;

                while ((value = input.read()) != -1) {
                    output.write(value - 45);
                    encrypted.append((char) ((byte)(value - 45)));
                }



            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return encrypted.toString();
    }

    public static String decrypt() {
        Path path = new PathCreator().createPathToFile("message_encrypted.dat", "output");
        Path out = new PathCreator().createPathToFile("message_decrypted.dat", "output");
        StringBuilder decrypted = new StringBuilder();

        try (FileInputStream input = new FileInputStream(path.toFile())) {
            try (FileOutputStream output = new FileOutputStream(out.toFile())) {

                int value;

                while ((value = input.read()) != -1) {
                    output.write(value + 45);
                    decrypted.append((char)((byte) (value + 45)));
                }



            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return decrypted.toString();
    }

}




