package com.algorand.algosdk.crypto;

import com.algorand.algosdk.logic.Logic;
import com.algorand.algosdk.util.Encoder;

import java.io.IOException;
import java.util.Arrays;

public class TEALProgram {
    private byte[] program;

    /**
     * Initialize a TEALProgram based on the byte array. An exception is thrown if the program is invalid.
     * @param program
     */
    public TEALProgram(byte[] program) throws IOException {
        Logic.readProgram(program, null);
        this.program = Arrays.copyOf(program, program.length);
    }

    /**
     * Initialize a TEALProgram based on the base64 encoding. An exception is thrown if the program is invalid.
     * @param base64String
     */
    public TEALProgram(String base64String) throws IOException {
        this(Encoder.decodeFromBase64(base64String));
    }
}
