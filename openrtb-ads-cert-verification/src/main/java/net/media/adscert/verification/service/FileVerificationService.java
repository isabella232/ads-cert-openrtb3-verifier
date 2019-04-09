package net.media.adscert.verification.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.media.adscert.exceptions.VerificationServiceException;
import net.media.adscert.models.OpenRTB;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.util.stream.Stream;

/**
 * This class is used to perform bulk verification of requests stored in a file.
 *
 * @author anupam.v
 *
 * @since 1.0
 */
public class FileVerificationService {

  /**
   * Performs verification of jsons stored in the file. Note that each line of the file should correspond to
   * the complete json, i.e. a json requested spanning multiple lines is not supported. There should be no empty
   * lines.
   *
   * @param inputFile path to the input file
   * @param outputFile path to the file in which output of verification is intended to be stored
   * @param mapper {@link ObjectMapper} to be used for converting JSON to an {@link OpenRTB} object
   * @param service see {@link VerificationService}
   */
  public static void verify(String inputFile, String outputFile, ObjectMapper mapper, VerificationService service, PublicKey publicKey) {
    try (Stream<String> stream = Files.lines(Paths.get(inputFile));
         FileOutputStream outputStream = new FileOutputStream(outputFile)) {
      stream.forEach(line -> {
        try {
          outputStream.write(((service.verifyRequest(mapper.readValue(line, OpenRTB.class),false, publicKey, false)
            ? "Success" : "Failed") + System.getProperty("line.separator")).getBytes());
        } catch (Exception e) {
          try {
            outputStream.write(("Failed: " + e.getMessage() + System.getProperty("line.separator")).getBytes());
          } catch (IOException e1) {
            throw new VerificationServiceException(e1);
          }
        }
      });
    } catch (IOException e) {
      throw new VerificationServiceException(e);
    }
  }

  /**
   * Performs verification of jsons stored in the file. Note that each line of the file should correspond to
   * the complete json, i.e. a json requested spanning multiple lines is not supported. There should be no empty
   * lines.
   *
   * @param inputFile path to the input file
   * @param outputFile path to the file in which output of verification is intended to be stored
   */
  public static void verify(String inputFile, String outputFile, PublicKey publicKey) {
    verify(inputFile, outputFile, new ObjectMapper(), new VerificationService(), publicKey);
  }

}