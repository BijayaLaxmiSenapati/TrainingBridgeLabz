package com.bridgelabz.addressbook.factory;

import com.bridgelabz.addressbook.repository.JDBCSerializer;
import com.bridgelabz.addressbook.repository.JSONSerializer;
import com.bridgelabz.addressbook.repository.Serializer;

public class SerializerFactory
{
	public Serializer getSerializer(String type)
	{
		if("JSON".equalsIgnoreCase(type))
		{
			return new JSONSerializer();
		}
		else if("JDBC".equalsIgnoreCase(type))
		{
			return new JDBCSerializer();
		}
		else
		{
			return null;
		}
	}
}
