package com.jm2dev.xslt;

import net.sf.saxon.s9api.*;
import org.hamcrest.core.IsCollectionContaining;
import org.junit.Test;

import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class TransformationsTest {
    @Test
    public void transformXmlStatementIntoCsv() {
        try {
            String xsl = "src/main/resources/xslt/xml2csv.xsl";
            String input = "src/test/resources/bank.xml";
            String output = "src/test/resources/bank.csv";
            performTransformation(xsl, input, output);
            Path actual = new File(output).toPath();
            assertThat(Files.readAllLines(actual), IsCollectionContaining.hasItem("        dd-mm-yyyy,this is a description,100.00,1000.00"));
        } catch (SaxonApiException e) {
            assertTrue(false);
        } catch (IOException ioe) {
            assertTrue(false);
        }
    }

    private void performTransformation(String xsl, String input, String output) throws SaxonApiException {
        Processor processor = new Processor(false);
        XsltCompiler compiler = processor.newXsltCompiler();
        XsltExecutable executable = compiler.compile(new StreamSource(new File(xsl)));
        XdmNode source = processor.newDocumentBuilder().build(new File(input));
        Serializer out = processor.newSerializer(new File(output));
        XsltTransformer transformer = executable.load();
        transformer.setInitialContextNode(source);
        transformer.setDestination(out);
        transformer.transform();
    }
}
