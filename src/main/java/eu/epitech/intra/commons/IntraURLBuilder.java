package eu.epitech.intra.commons;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;

import eu.epitech.intra.commons.helpers.IntraPropertiesHelper;

public abstract class IntraURLBuilder {

	public class Parameters extends ArrayList<NameValuePair> {
		private static final long serialVersionUID = -4046532115917579440L;

		public boolean add(String name, String value) {
			if (isEmpty()) {
				add(new BasicNameValuePair("format", "json"));
			}
			return add(new BasicNameValuePair(name, value));
		}
	}

	private final String path;
	private final boolean forced;

	public IntraURLBuilder(String path) {
		this(path, false);
	}

	public IntraURLBuilder(String path, boolean forced) {
		super();
		this.path = path;
		this.forced = forced;
	}

	public URI build() {
		Parameters parameters = new Parameters();

		build(parameters);

		final URIBuilder builder = new URIBuilder();
		builder.setScheme("https");
		builder.setHost("intra.epitech.eu");
		builder.setPort(-1);
		builder.setPath(IntraPropertiesHelper.getLogasPath(path));
		if (forced || !parameters.isEmpty()) {
			if (parameters.isEmpty()) {
				parameters.add(new BasicNameValuePair("format", "json"));
			}
			builder.addParameters(parameters);
		}

		try {
			return builder.build();
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	protected abstract void build(Parameters parameters);
}
