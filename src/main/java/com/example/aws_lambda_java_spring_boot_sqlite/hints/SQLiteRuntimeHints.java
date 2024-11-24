package com.example.aws_lambda_java_spring_boot_sqlite.hints;

import org.hibernate.community.dialect.SQLiteDialect;
import org.hibernate.dialect.Dialect;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.TypeReference;

public class SQLiteRuntimeHints implements RuntimeHintsRegistrar {
    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        // Register the SQLite dialect
        hints.reflection().registerType(SQLiteDialect.class, builder ->
                builder.withMembers(MemberCategory.INVOKE_DECLARED_CONSTRUCTORS,
                        MemberCategory.INVOKE_DECLARED_METHODS,
                        MemberCategory.DECLARED_FIELDS,
                        MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS,
                        MemberCategory.INVOKE_PUBLIC_METHODS,
                        MemberCategory.PUBLIC_FIELDS)
        );

        // Register the Dialect superclass
        hints.reflection().registerType(Dialect.class, builder ->
                builder.withMembers(MemberCategory.INVOKE_DECLARED_CONSTRUCTORS,
                        MemberCategory.INVOKE_DECLARED_METHODS)
        );

        // Register for JDK proxies
        hints.proxies().registerJdkProxy(
                TypeReference.of(SQLiteDialect.class),
                TypeReference.of(Dialect.class)
        );
    }
}