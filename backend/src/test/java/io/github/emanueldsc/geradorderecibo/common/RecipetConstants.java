package io.github.emanueldsc.geradorderecibo.common;

import io.github.emanueldsc.geradorderecibo.models.Recipet;

public class RecipetConstants {

    public static final Recipet RECIPET_VALID = new Recipet(
            1,
            3200.99,
            "Yorick O Pastor de Almas",
            "Zaunita amorfo de combate (Zac)",
            "Bastão das Eras",
            "Summoners Rift - Rune Terra",
            "84483198009");

    public static final Recipet RECIPET_INVALID = new Recipet();

    public static final String KEY_RECIPET_VALID = "763E3CCF00D7E042E57481FE69090213A60F17018A5AC2A61F9EE107E8F32E3E";

    public static final String CIPHER_RECIPET_VALID = "MQ==.MzIwMC45OQ==.WW9yaWNrIE8gUGFzdG9yIGRlIEFsbWFz.WmF1bml0YSBhbW9yZm8gZGUgY29tYmF0ZSAoWmFjKQ==.QmFzdMOjbyBkYXMgRXJhcw==.ODQ0ODMxOTgwMDk=.NzYzRTNDQ0YwMEQ3RTA0MkU1NzQ4MUZFNjkwOTAyMTNBNjBGMTcwMThBNUFDMkE2MUY5RUUxMDdFOEYzMkUzRQ==";

}
