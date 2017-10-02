

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'tp.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'tp.UserRole'
grails.plugin.springsecurity.authority.className = 'tp.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['IS_AUTHENTICATED_FULLY']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/dbconsole/**',   access: ['permitAll']],
	[pattern: '/DBPhoto/**',   access: ['permitAll']],
	[pattern: '/pages/**',   access: ['permitAll']],
	[pattern: '/google.gsp',   access: ['permitAll']],

	[pattern: '/userRole/**',      access: ['permitAll']],
	[pattern: '/user/**',      access: ['permitAll']],

	[pattern: '/emplacement/**', access: ['permitAll']],
	[pattern: '/groupePoi/**',  access: ['permitAll']],
	[pattern: '/media/**',  access: ['permitAll']],
	[pattern: '/poi/**',  access: ['permitAll']],
	[pattern: 'tp/dbconsole',  access: ['permitAll']],


	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]


