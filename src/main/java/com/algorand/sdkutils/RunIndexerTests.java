package com.algorand.sdkutils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import com.algorand.algosdk.v2.client.connect.Client;
import com.algorand.sdkutils.generators.JsonUtils;
import com.algorand.sdkutils.generators.TestGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public class RunIndexerTests extends TestGenerator{

	RunIndexerTests(JsonNode root) {
		super(root);
	}

	public static void main (String args[]) throws JsonProcessingException, IOException {
		File f = new File("../openapi-server-generator/scripts/indexer.oas2.yml");
		FileInputStream fis = new FileInputStream(f);

		JsonNode root = JsonUtils.getRoot(fis);	
		TestGenerator tg = new TestGenerator(root);


		int port = 8980;
		String host = "localhost";
		Client client = new Client(host, port);

		File inFile = new File("./src/main/java/com/algorand/sdkutils/test.csv");
		BufferedReader br = new BufferedReader(new FileReader(inFile));
		testSamples(tg, br, client, true);
		br.close();
		System.out.println("File tested: " + "./src/main/java/com/algorand/sdkutils/test.csv");
	}
}
