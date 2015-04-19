#include <jni.h>
/* Header for class com_example_haha_JNITest */

#ifndef _Included_com_example_haha_JNITest
#define _Included_com_example_haha_JNITest
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_example_haha_JNITest
 * Method:    add
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_com_example_nina_JNITest_add(JNIEnv *env, jobject obj, jint j1, jint j2)
{
	return j1+ j2;
};
#ifdef __cplusplus
}
#endif
#endif
