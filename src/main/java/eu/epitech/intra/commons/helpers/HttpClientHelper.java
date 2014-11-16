package eu.epitech.intra.commons.helpers;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import eu.epitech.intra.builders.LoginIntraURLBuilder;
import eu.epitech.intra.commons.IntraURLBuilder;

public class HttpClientHelper {
	private static HttpClient client = null;

	private static final HttpClient getClient() {

		if (client == null) {
			try {

				final HttpClientBuilder clientBuilder = HttpClientBuilder.create();

				client = clientBuilder.build();

				final List<NameValuePair> parameters = new ArrayList<>();
				parameters.add(new BasicNameValuePair("login", IntraPropertiesHelper.getLogin()));
				parameters.add(new BasicNameValuePair("password", IntraPropertiesHelper.getPassword()));
				parameters.add(new BasicNameValuePair("remind", "on"));

				final HttpPost request = new HttpPost(LoginIntraURLBuilder.newBuilder().build());
				request.setEntity(new UrlEncodedFormEntity(parameters));

				HttpClientHelper.getResponseContent(client, request);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		return client;

	}

	private static final String getResponseContent(final HttpClient client, final HttpUriRequest request) {
		final StringWriter writer = new StringWriter();
		try {
			request.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:32.0) Gecko/20100101 Firefox/32.0");
			request.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			request.setHeader("Accept-Language", "fr,fr-fr;q=0.8,en-us;q=0.5,en;q=0.3");
			request.setHeader("Accept-Encoding", "gzip, deflate");

			final HttpResponse response = client.execute(request);
			final InputStream inputStream = response.getEntity().getContent();

			IOUtils.copy(inputStream, writer);

			IOUtils.closeQuietly(inputStream);
			IOUtils.closeQuietly(writer);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return writer.toString();
	}

	private static final String getResponseContent(final HttpUriRequest request) {
		return getResponseContent(getClient(), request);
	}

	public static final JSONArray getJSONArray(final IntraURLBuilder builder) {
		final HttpGet request = new HttpGet(builder.build());
		return JSONArray.fromObject(getResponseContent(request));
	}

	public static final JSONObject getJSONObject(final IntraURLBuilder builder) {
		final HttpGet request = new HttpGet(builder.build());
		return JSONObject.fromObject(getResponseContent(request));
	}
}
