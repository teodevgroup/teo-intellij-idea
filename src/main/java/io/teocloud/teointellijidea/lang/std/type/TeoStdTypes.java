package io.teocloud.teointellijidea.lang.std.type;

public final class TeoStdTypes {
    public static TeoStdType BOOL = new TeoStdBoolType();
    public static TeoStdType STRING = new TeoStdStringType();
    public static TeoStdType NUMBER = new TeoStdNumberType();
    public static TeoStdType INTEGER = new TeoStdIntegerType();
    public static TeoStdType SIGNED_INTEGER = new TeoStdSignedIntegerType();
    public static TeoStdType UNSIGNED_INTEGER = new TeoStdUnsignedIntegerType();
    public static TeoStdType FLOAT_POINT = new TeoStdFloatPointType();
    public static TeoStdType FLOAT_32 = new TeoStdFloat32Type();
    public static TeoStdType FLOAT_64 = new TeoStdFloat64Type();
    public static TeoStdRegexType REGEX = new TeoStdRegexType();

    public static TeoStdNullType NULL = new TeoStdNullType();

    public static TeoStdScalarFieldEnumType SCALAR_FIELD_ENUM = new TeoStdScalarFieldEnumType();

}
