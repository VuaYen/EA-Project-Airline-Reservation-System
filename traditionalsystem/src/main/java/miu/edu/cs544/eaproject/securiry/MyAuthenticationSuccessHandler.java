package miu.edu.cs544.eaproject.securiry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MyAuthenticationSuccessHandler {

//    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
//
//    public MyAuthenticationSuccessHandler() {
//        super();
//    }
//
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
//        handle(httpServletRequest, httpServletResponse, authentication);
//        clearAuthenticationAttributes(httpServletRequest);
//    }
//
//    protected void handle(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws IOException {
//        final String targetUrl = determineTargetUrl(authentication);
//
//        if (response.isCommitted()) {
//            System.out.println("Response has already been committed. Unable to redirect to " + targetUrl);
//            return;
//        }
//
//        redirectStrategy.sendRedirect(request, response, targetUrl);
//    }
//
//    protected String determineTargetUrl(final Authentication authentication) {
//
//        Map<String, String> roleTargetUrlMap = new HashMap<>();
//        roleTargetUrlMap.put("ROLE_PASSENGER", "/");
//        roleTargetUrlMap.put("ROLE_ADMIN", "/admin");
//        roleTargetUrlMap.put("ROLE_AGENT", "/agent");
//
//        final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//        for (final GrantedAuthority grantedAuthority : authorities) {
//
//            String authorityName = grantedAuthority.getAuthority();
//            if (roleTargetUrlMap.containsKey(authorityName)) {
//                return roleTargetUrlMap.get(authorityName);
//            }
//        }
//
//        throw new IllegalStateException();
//    }
//
//    protected final void clearAuthenticationAttributes(final HttpServletRequest request) {
//        final HttpSession session = request.getSession(false);
//
//        if (session == null) {
//            return;
//        }
//
//        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
//    }
}
