package interview;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class KlazzTest {
    @Test
    public void name() {
        File f = new File("");
        InputStream is = null;

        {
            try {
                is = new FileInputStream("file.xml");
                StringBuilder resultStringBuilder = new StringBuilder();
                try(BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                    String line = null;
                    while (true) {
                        try {
                            if ((line = br.readLine()) == null) break;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        resultStringBuilder.append(line).append("\n");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Klazz a = mock(Klazz.class);

        assertThat(5).isEqualTo(5);
        //return resultStringBuilder.toString();
    }

}