#include "jnidemo.h"
#include <windows.h>
 
JNIEXPORT jint JNICALL Java_eu_javablog_jni_JNIDemo_calculateStringLength(JNIEnv *env, jobject jobj, jstring text) {
 
          jsize length = (*env)->GetStringLength(env, text);
          return length;
}
