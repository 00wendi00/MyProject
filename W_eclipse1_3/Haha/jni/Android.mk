LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := Haha
### Add all source file names to be included in lib separated by a whitespace
LOCAL_SRC_FILES :=  com_example_haha_JNITest.c

include $(BUILD_SHARED_LIBRARY)
