package org.example;

import java.io.IOException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PersonReaderDiffblueTest {
    /**
     * Method under test: {@link PersonReader#readPersonsFromCSV(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testReadPersonsFromCSV() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.io.FileNotFoundException: \directory\foo.txt (El sistema no puede encontrar la ruta especificada)
        //       at java.io.FileInputStream.open0(Native Method)
        //       at java.io.FileInputStream.open(FileInputStream.java:216)
        //       at java.io.FileInputStream.<init>(FileInputStream.java:157)
        //       at java.io.FileInputStream.<init>(FileInputStream.java:111)
        //       at java.io.FileReader.<init>(FileReader.java:60)
        //       at org.example.PersonReader.readPersonsFromCSV(PersonReader.java:30)
        //   See https://diff.blue/R013 to resolve this issue.

        (new PersonReader()).readPersonsFromCSV("/directory/foo.txt");
    }
}

