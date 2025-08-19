package org.nfactorial.newsfeed.common.security;

import org.nfactorial.newsfeed.common.security.adapter.SecurityMockProfile;

public interface GetProfileFromAccountIdApi {
	SecurityMockProfile execute(long accountId);
}
