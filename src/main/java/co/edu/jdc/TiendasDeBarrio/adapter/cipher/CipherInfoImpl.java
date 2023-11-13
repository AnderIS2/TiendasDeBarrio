package co.edu.jdc.TiendasDeBarrio.adapter.cipher;

import co.edu.jdc.TiendasDeBarrio.usecase.port.CipherInfo;
import org.apache.commons.codec.digest.DigestUtils;

public class CipherInfoImpl implements CipherInfo {
        @Override
        public String encrypt(String text) {
            return DigestUtils.sha256Hex(text);
        }
}
