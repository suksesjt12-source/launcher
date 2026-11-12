cmake_minimum_required(VERSION 3.22.1)

project(PCRecompiler)

add_library(
    pcruntime
    SHARED
    native_runtime.cpp
)

find_library(
    log-lib
    log
)

target_link_libraries(
    pcruntime
    ${log-lib}
)
