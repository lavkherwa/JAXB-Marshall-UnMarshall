package com.lav.jaxb.adapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/* For handling complex types we need to tell the JAXB how to marshal and unMarshal 
 * using custom adaptor implementation
 */
public class DateAdapter extends XmlAdapter<String, Date> {

	private static final ThreadLocal<DateFormat> dateFormat = new ThreadLocal<DateFormat>() {

		@Override
		protected DateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};

	@Override
	public Date unmarshal(String v) throws Exception {
		return dateFormat.get().parse(v);
	}

	@Override
	public String marshal(Date v) throws Exception {
		return dateFormat.get().format(v);
	}
}