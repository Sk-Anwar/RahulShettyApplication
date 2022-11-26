package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FileUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReaderJson {

	public List<HashMap<String, String>> getJsonDataTOMap(String filePath) throws IOException {
		// read Json to String
		String jsoncontent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

		// String to HasMap - Jason Databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsoncontent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

}