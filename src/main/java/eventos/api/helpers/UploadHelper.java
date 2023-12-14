package eventos.api.helpers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

public class UploadHelper {
    public static String uploadBase64(String base64Data) {
        try {
            String[] parts = base64Data.split(",");
            String mimeType = parts[0].split(":")[1].split(";")[0];
            String ext = mimeType.split("/")[1];

            String nomeDoArquivo = UUID.randomUUID().toString() + "." + ext;

            // Remova o prefixo "data:image/png;base64," ou similar, se estiver presente
            String base64Image = base64Data.split(",")[1];

            // Decodifique a string base64 em bytes
            byte[] fileBytes = Base64.getDecoder().decode(base64Image);

            String projectDirectory = System.getProperty("user.dir"); // Obtém o diretório atual do projeto
            String uploadsDirectory = "uploads";
            String destinationDirectory = Paths.get(projectDirectory, uploadsDirectory).toString();

            // Caminho para salvar o arquivo - ajuste conforme necessário
            String filePath = destinationDirectory + "/" + nomeDoArquivo;

            // Salve os bytes no arquivo
            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                fos.write(fileBytes);
            }

            return "/uploads/" + nomeDoArquivo;
        } catch (IOException e) {
            e.printStackTrace();
            return "Erro ao salvar o arquivo: " + e.getMessage();
        }
    }
}
