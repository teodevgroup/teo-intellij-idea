package io.teocloud.teointellijidea.lang.std.argument.types;

public final class TeoStdArgumentTypes {
    public static TeoStdArgumentType BOOL = new TeoStdBoolArgumentType("BOOL");
    public static TeoStdArgumentType STRING = new TeoStdArgumentType("STRING");
    public static TeoStdArgumentType NUMBER = new TeoStdIntegerArgumentType("NUMBER");
    public static TeoStdArgumentType INTEGER = new TeoStdIntegerArgumentType("INTEGER");
    public static TeoStdArgumentType SIGNED_INTEGER = new TeoStdSignedIntegerArgumentType("SIGNED_INTEGER");
    public static TeoStdArgumentType INT_8 = new TeoStdSignedIntegerArgumentType("INT_8");
    public static TeoStdArgumentType INT_16 = new TeoStdSignedIntegerArgumentType("INT_16");
    public static TeoStdArgumentType INT_32 = new TeoStdSignedIntegerArgumentType("INT_32");
    public static TeoStdArgumentType INT_64 = new TeoStdSignedIntegerArgumentType("INT_64");
    public static TeoStdArgumentType UNSIGNED_INTEGER = new TeoStdSignedIntegerArgumentType("UNSIGNED_INTEGER");
    public static TeoStdArgumentType UINT_8 = new TeoStdSignedIntegerArgumentType("UINT_8");
    public static TeoStdArgumentType UINT_16 = new TeoStdSignedIntegerArgumentType("UINT_16");
    public static TeoStdArgumentType UINT_32 = new TeoStdSignedIntegerArgumentType("UINT_32");
    public static TeoStdArgumentType UINT_64 = new TeoStdSignedIntegerArgumentType("UINT_64");
    public static TeoStdArgumentType FLOAT_POINT = new TeoStdFloatPointArgumentType("FLOAT_POINT");
    public static TeoStdArgumentType FLOAT_32 = new TeoStdFloatPointArgumentType("FLOAT_32");
    public static TeoStdArgumentType FLOAT_64 = new TeoStdFloatPointArgumentType("FLOAT_64");
    public static TeoStdRegexArgumentType REGEX = new TeoStdRegexArgumentType("REGEX");

    public static TeoStdNullArgumentType NULL = new TeoStdNullArgumentType("NULL");

    public static TeoStdSyncedEnumType ENUM_MODEL_SCALAR_FIELDS = new TeoStdSyncedEnumType("ENUM_MODEL_SCALAR_FIELDS");

}
