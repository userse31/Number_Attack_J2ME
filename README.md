# Number_Attack_J2ME
Number Attack, but ported to J2ME. Designed for the Samsung SPH-M330.

# Installing on the SPH-M330
This will overwrite the builtin "The Price is Right" demo! Hence, why the main class is "Game_PRICE".

Using something like QCSuper or BitPIM (BitPIM likes to cause the phone to factory reset):
-On the phone's filesystem, go to "/brew/card1/AMSDL/CONTENT/Games/The_Pr035".
-Overwrite "The_Pr035.jar" with "./dist/Number_Attack.jar".
-Overwrite "The_Pr035.jad" with "./dist/Number_Attack.jad".

This won't change the original entry in the "Games" folder (which is annoying...), but it will replace the jar, allowing Number Attack to run on the phone.
