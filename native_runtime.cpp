#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_pcrecomp_launcher_MainActivity_getNativeStatus(
    JNIEnv* env,
    jobject
) {

    std::string status =
        "ARM64 Native Core Initialized";

    return env->NewStringUTF(status.c_str());
}
