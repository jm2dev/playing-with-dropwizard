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
            Processor processor = new Processor(false);
            XsltCompiler compiler = processor.newXsltCompiler();
            XsltExecutable executable = compiler.compile(new StreamSource(new File("src/main/xslt/xml2csv.xsl")));
            XdmNode source = processor.newDocumentBuilder().build(new File("src/main/resources/bank.xml"));
            Serializer out = processor.newSerializer(new File("src/test/resources/bank.csv"));
            out.setOutputProperty(Serializer.Property.METHOD, "text");
            out.setOutputProperty(Serializer.Property.INDENT, "no");
            XsltTransformer transformer = executable.load();
            transformer.setInitialContextNode(source);
            transformer.setDestination(out);
            transformer.transform();

            Path actual = new File("src/test/resources/bank.csv").toPath();
            assertThat(Files.readAllLines(actual), IsCollectionContaining.hasItem("    dd-mm-yyyy,this is a description,100.00,1000.00"));
        } catch (SaxonApiException e) {
            assertTrue(false);
        } catch (IOException ioe) {
            assertTrue(false);
        }
    }
}
