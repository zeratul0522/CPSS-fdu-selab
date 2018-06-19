package cn.edu.fudan.selab.smartHomeController.user;

import com.sun.org.apache.xml.internal.security.algorithms.JCEMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.DefaultJwtBuilder;
import io.jsonwebtoken.impl.DefaultJwtParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.Console;
import java.io.EOFException;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPrivateKey;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

@Service
public class JWTService {

    public static String generateJWT(User user) throws IllegalArgumentException, UnsupportedEncodingException
    {
        Algorithm algorithm = Algorithm.HMAC256("secret");
        String username = user.getName();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create().withHeader(map).withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + 360000)).sign(algorithm);
        return token;
    }

    public DecodedJWT parse(String token)
    {
        DecodedJWT decodedJWT = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            decodedJWT = jwtVerifier.verify(token);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JWTVerificationException e) {
            e.printStackTrace();
        }
        return decodedJWT;
    }
//
//    @Value("${jwt.key.store}") private String keystore;
//    @Value("${jwt.key.pass}") private String keypass;
//    @Value("${jwt.key.alias}") private String keyalias;
//    @Value("${jwt.cert}") private String cert;
//
//
//    private PrivateKey privateKey;
//    private PublicKey publicKey;
//
//    public String name = null;
//
//
//    @PostConstruct
//    public void initPrivateKey() throws Exception{
//        char[] pass = keypass.toCharArray();
//        KeyStore from = KeyStore.getInstance("JKS", "SUN");
//        from.load(new ClassPathResource(keystore).getInputStream(), pass);
//        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
//        X509Certificate x509Cert = (X509Certificate) certificateFactory.generateCertificate(new ClassPathResource(cert).getInputStream());
//        publicKey = x509Cert.getPublicKey();
//        privateKey = (ECPrivateKey) from.getKey(keyalias, pass);
//    }
//
//    public String generateJWT(User user){
//
//        return new DefaultJwtBuilder()
//                .setId(UUID.randomUUID().toString())
//                .setSubject(user.getName())
//                .setExpiration(Date.from(ZonedDateTime.now().plusDays(1).toInstant()))
//                .signWith(SignatureAlgorithm.ES256, privateKey).compact();
//    }
//
//    public String parse(String token){
//        try {
//            Jws<Claims> jws = new DefaultJwtParser().setSigningKey(publicKey).parseClaimsJws(token);
//            Claims claims = jws.getBody();
//            return name = claims.getSubject();
//        } catch (SignatureException e){
//            System.out.println("JWT is error! The signature is unexpected");
//            return "ERROR";
//        }
//
//
//    }
}
//
//public class JWTService {
//
//    public static String initToken(User user) throws IllegalArgumentException, UnsupportedEncodingException {
//        String name = user.getName();
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("alg", "HS256");
//        map.put("typ", "JWT");
//        String token = new DefaultJwtBuilder().set
//    }
//
//}
