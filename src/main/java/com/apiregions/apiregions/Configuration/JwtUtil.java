package com.apiregions.apiregions.Configuration;

public class JwtUtil {

    public  static   final long EXPIRE_TOKEN = 20*60*1000;
    public  static final long REFRESH_TOKEN = 240*60*1000;
    public  static final String SECRET = "MonSecret";
    public  static final String AUTHORIZATION = "Authorization";
    public  static final String PREFIX = "Bearer ";
/*  private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

  @Value("${bezkoder.app.jwtSecret}")
  private String jwtSecret;

  @Value("${bezkoder.app.jwtExpirationMs}")
  private int jwtExpirationMs;

  public String generateJwtToken(Authentication authentication) {

    UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

    return Jwts.builder()
      .setSubject((userPrincipal.getUsername()))
      .setIssuedAt(new Date())
      .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
      .signWith(SignatureAlgorithm.HS512, jwtSecret)
      .compact();
  }

  public String getUserNameFromJwtToken(String token) {
    return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
  }

  public boolean validateJwtToken(String authToken) {
    try {
      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
      return true;
    } catch (SignatureException e) {
      logger.error("Invalid JWT signature: {}", e.getMessage());
    } catch (MalformedJwtException e) {
      logger.error("Invalid JWT token: {}", e.getMessage());
    } catch (ExpiredJwtException e) {
      logger.error("JWT token is expired: {}", e.getMessage());
    } catch (UnsupportedJwtException e) {
      logger.error("JWT token is unsupported: {}", e.getMessage());
    } catch (IllegalArgumentException e) {
      logger.error("JWT claims string is empty: {}", e.getMessage());
    }

    return false;
  }*/
    /*public  static   final long EXPIRE_TOKEN = 20*60*1000;
    public  static final long REFRESH_TOKEN = 240*60*1000;
    public  static final String SECRET = "MonSecret";
    public  static final String AUTHORIZATION = "Authorization";
    public  static final String PREFIX = "Bearer ";*/
}
