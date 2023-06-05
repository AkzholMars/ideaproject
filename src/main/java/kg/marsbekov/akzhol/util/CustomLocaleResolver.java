package kg.marsbekov.akzhol.util;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class CustomLocaleResolver extends AcceptHeaderLocaleResolver {

    List<Locale> LOCALES = Arrays.asList(
            new Locale("ru"),
            new Locale("en"));

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        if (StringUtils.isEmpty(request.getHeader("language"))){
            return Locale.getDefault();
        }
        List<Locale.LanguageRange> list
                = Locale.LanguageRange.parse(request.getHeader("language"));
        return Locale.lookup(list, LOCALES);

    }
}