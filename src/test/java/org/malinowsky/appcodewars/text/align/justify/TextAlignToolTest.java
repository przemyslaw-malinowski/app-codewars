package org.malinowsky.appcodewars.text.align.justify;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// TODO: Replace examples and use TDD by writing your own tests

class TextAlignToolTest {
    @Test
    void sampleTests() {
        assertEquals("123  45\n6", new TextAlignTool().justify("123 45 6", 7));
        assertEquals("123", new TextAlignTool().justify("123", 7));
        assertEquals("", new TextAlignTool().justify("", 10));
    }

    @Test
    void betterSample() {
        String justify = new TextAlignTool().justify(LIPSUM, 30);
        System.out.println(justify);
    }

    private static final String LIPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sa"
            + "gittis dolor mauris, at elementum ligula tempor eget. In quis rhoncus nunc, at aliquet orci. Fusc"
            + "e at dolor sit amet felis suscipit tristique. Nam a imperdiet tellus. Nulla eu vestibulum urna. V"
            + "ivamus tincidunt suscipit enim, nec ultrices nisi volutpat ac. Maecenas sit amet lacinia arcu, no"
            + "n dictum justo. Donec sed quam vel risus faucibus euismod. Suspendisse rhoncus rhoncus felis at f"
            + "ermentum. Donec lorem magna, ultricies a nunc sit amet, blandit fringilla nunc. In vestibulum vel"
            + "it ac felis rhoncus pellentesque. Mauris at tellus enim. Aliquam eleifend tempus dapibus. Pellent"
            + "esque commodo, nisi sit amet hendrerit fringilla, ante odio porta lacus, ut elementum justo nulla"
            + " et dolor.";

    @Test
    void descriptionExample() {
        String expected = "Lorem  ipsum  dolor  sit amet,\nconsectetur  adipiscing  elit.\n"
                + "Vestibulum    sagittis   dolor\nmauris,  at  elementum  ligula\ntempor  eget.  In quis rhoncus\n"
                + "nunc,  at  aliquet orci. Fusce\nat   dolor   sit   amet  felis\nsuscipit   tristique.   Nam  a\n"
                + "imperdiet   tellus.  Nulla  eu\nvestibulum    urna.    Vivamus\ntincidunt  suscipit  enim, nec\n"
                + "ultrices   nisi  volutpat  ac.\nMaecenas   sit   amet  lacinia\narcu,  non dictum justo. Donec\n"
                + "sed  quam  vel  risus faucibus\neuismod.  Suspendisse  rhoncus\nrhoncus  felis  at  fermentum.\n"
                + "Donec lorem magna, ultricies a\nnunc    sit    amet,   blandit\nfringilla  nunc. In vestibulum\n"
                + "velit    ac    felis   rhoncus\npellentesque. Mauris at tellus\nenim.  Aliquam eleifend tempus\n"
                + "dapibus. Pellentesque commodo,\nnisi    sit   amet   hendrerit\nfringilla,   ante  odio  porta\n"
                + "lacus,   ut   elementum  justo\nnulla et dolor.";

        System.out.println(new TextAlignTool().justify(LIPSUM, 30));
        assertEquals(expected, new TextAlignTool().justify(LIPSUM, 30));
    }
}
