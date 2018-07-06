package com.bridgelabz.factory;

import com.bridgelabz.repository.JDBCSerializer;
import com.bridgelabz.repository.JSONSerializer;
import com.bridgelabz.repository.Serializer;

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
