#
# Copyright (C) 2008 The Android Open Source Project
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

# The sdkuilib code has moved to tools/swt/sdkuilib.
# The rule below uses the prebuilt sdkuilib.jar if found.
#
# If you want to run the tests, cd to tools/swt
# and run ./gradlew :sdkuilib:test

LOCAL_MODULE := sdkuilib
LOCAL_MODULE_TAGS := optional

LOCAL_JAVA_LIBRARIES := \
	common \
	commons-codec-1.4 \
	commons-compress-1.0 \
	commons-logging-1.1.1 \
	httpclient-4.1.1 \
	httpcore-4.1 \
	httpmime-4.1.1 \
	org.eclipse.jface_3.6.2.M20110210-1200 \
	org.eclipse.equinox.common_3.6.0.v20100503 \
	org.eclipse.core.commands_3.6.0.I20100512-1500 \
	sdklib \
	layoutlib_api \
	swt \
	swtmenubar

LOCAL_PREBUILT_JAVA_LIBRARIES := \
	../../../../prebuilts/devtools/$(LOCAL_MODULE)$(COMMON_JAVA_PACKAGE_SUFFIX)

include $(BUILD_HOST_PREBUILT)

