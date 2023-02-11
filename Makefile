
PWD=$(shell pwd)
AAP_JUCE_DIR=$(PWD)/external/aap-juce

APP_NAME="Surge XT"

APP_BUILD_DIR=$(PWD)
APP_SRC_DIR=$(PWD)/external/surge
JUCE_DIR=$(APP_SRC_DIR)/libs/JUCE

# FIXME: it sill fails to build desktop version.
APP_SHARED_CODE_LIBS="src/platform/libsurge-platform.a:src/common/libsurge-common.a:src/common/libsurge-common-binary.a:src/surge-xt/libsurge-xt-binary.a:src/lua/libsurge-lua-src.a:src/clap-extensions/libclap_juce_extensions.a:libs/LuaJitLib/luajit/bin/libluajit.a:libs/airwindows/libairwindows.a:libs/eurorack/libeurorack.a:libs/fmt/libfmt.a:libs/libsamplerate/src/libsamplerate.a:libs/oddsound-mts/liboddsound-mts.a:libs/sqlite-3.23.3/libsqlite.a:libs/sst/sst-plugininfra/libs/filesystem/libfilesystem.a:libs/sst/sst-plugininfra/libs/strnatcmp/libstrnatcmp.a:libs/sst/sst-plugininfra/libs/tinyxml/libtinyxml.a:libs/sst/sst-plugininfra/libsst-plugininfra.a:src/surge-xt/surge-xt_artefacts/Release/libSurge XT_SharedCode.a"

PATCH_FILE=$(PWD)/aap-juce-support.patch
PATCH_DEPTH=1

include $(AAP_JUCE_DIR)/Makefile.cmake-common
