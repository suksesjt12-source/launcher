package com.pcrecomp.launcher;

import java.io.*;

public class PEAnalyzer {

    public static String analyze(InputStream input)
            throws Exception {

        byte[] header = new byte[4096];

        int length = input.read(header);

        if (length < 64 ||
            header[0] != 'M' ||
            header[1] != 'Z') {

            return "INVALID_EXECUTABLE";
        }

        int offset =
            (header[60] & 255) |
            ((header[61] & 255) << 8) |
            ((header[62] & 255) << 16) |
            ((header[63] & 255) << 24);

        if (offset < 0 || offset + 6 > length) {
            return "INVALID_PE_HEADER";
        }

        if (header[offset] != 'P' ||
            header[offset + 1] != 'E') {

            return "INVALID_PE_SIGNATURE";
        }

        int machine =
            (header[offset + 4] & 255) |
            ((header[offset + 5] & 255) << 8);

        switch (machine) {

            case 0x014c:
                return "WINDOWS_X86_32";

            case 0x8664:
                return "WINDOWS_X64";

            case 0xAA64:
                return "WINDOWS_ARM64";

            default:
                return "UNKNOWN_ARCHITECTURE";
        }
    }
}
