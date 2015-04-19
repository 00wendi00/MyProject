# This is a generated file. Please do not edit.

.PHONY: all

COMMANDS := 	\
	    scd_cmd_1

all: $(COMMANDS)

scd_cmd_1:
	@echo begin generating scanner info for $@
	E:/ndk/toolchains/arm-linux-androideabi-4.8/prebuilt/windows-x86_64/bin/arm-linux-androideabi-gcc -march=armv5te -mtune=xscale -msoft-float -mthumb -Os -D 'NDEBUG=1' -finline-limit=64 -D 'ANDROID=1' -I "E:\workplace\W_eclipse1_3\Nnnn\jni" -I "E:\ndk\platforms\android-21\arch-arm\usr\include" -E -P -v -dD specs.c
	@echo end generating scanner info for $@


