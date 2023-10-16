package edu.hfcc;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class EncryptDecryptFileTest {

    @Test
    public void encrypt() {
        String actual;

       actual = EncryptDecryptFile.encrypt();

        assertThat(actual).isEqualTo("\uFFF4\uFFF4'BC\uFFF3&86E8G\uFFF4\uFFF4\uFFDD';<F\uFFF3@8FF4:8\uFFF3F;BH?7\uFFF358\uFFF38A6ELCG87\u0001");
    }

    @Test
    public void decrypt() {

        String actual = EncryptDecryptFile.decrypt();

        assertThat(actual).isEqualTo("!!Top Secret!!\n" +
                "This message should be encrypted.");

    }

}

