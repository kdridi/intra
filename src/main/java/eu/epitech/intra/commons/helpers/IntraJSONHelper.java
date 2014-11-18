package eu.epitech.intra.commons.helpers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class IntraJSONHelper {

	public static <T> T readTypeReference(final InputStream in, final TypeReference<T> typeRef) {
		return readTypeReference(new BufferedReader(new InputStreamReader(in)), typeRef);
	}

	public static <T> T readTypeReference(final Reader reader, final TypeReference<T> typeRef) {
		T result = null;
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final JsonFactory factory = mapper.getFactory();
			final JsonParser parser = factory.createParser(reader);
			parser.enable(Feature.ALLOW_COMMENTS);
			result = parser.readValueAs(typeRef);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}
}
