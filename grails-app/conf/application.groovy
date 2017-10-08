
// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'tp.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'tp.UserRole'
grails.plugin.springsecurity.authority.className = 'tp.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['IS_AUTHENTICATED_FULLY']],
	[pattern: '/error',          access: ['IS_AUTHENTICATED_FULLY']],
	[pattern: '/index',          access: ['IS_AUTHENTICATED_FULLY']],
	[pattern: '/index.gsp',      access: ['IS_AUTHENTICATED_FULLY']],
	[pattern: '/shutdown',       access: ['IS_AUTHENTICATED_FULLY']],
	[pattern: '/dbconsole/**',   access: ['IS_AUTHENTICATED_FULLY']],
	[pattern: '/DBPhoto/**',   access: ['IS_AUTHENTICATED_FULLY']],
	[pattern: '/pages/**',   access: ['IS_AUTHENTICATED_FULLY']],
	[pattern: '/google.gsp',   access: ['IS_AUTHENTICATED_FULLY']],

	[pattern: '/userRole/**',      access: ['IS_AUTHENTICATED_FULLY']],
	[pattern: '/user/**',      access: ['IS_AUTHENTICATED_FULLY']],
	[pattern: '/role/**',      access: ['IS_AUTHENTICATED_FULLY']],

	[pattern: '/emplacement/**', access: ['IS_AUTHENTICATED_FULLY']],
	[pattern: '/groupePoi/**',  access: ['IS_AUTHENTICATED_FULLY']],
	[pattern: '/media/**',  access: ['IS_AUTHENTICATED_FULLY']],
	[pattern: '/poi/**',  access: ['IS_AUTHENTICATED_FULLY']],
	[pattern: 'tp/dbconsole',  access: ['IS_AUTHENTICATED_FULLY']],
	[pattern: '/mediaPoi/**',  access: ['IS_AUTHENTICATED_FULLY']],


	[pattern: '/assets/**',      access: ['IS_AUTHENTICATED_FULLY']],
	[pattern: '/**/js/**',       access: ['IS_AUTHENTICATED_FULLY']],
	[pattern: '/**/css/**',      access: ['IS_AUTHENTICATED_FULLY']],
	[pattern: '/**/images/**',   access: ['IS_AUTHENTICATED_FULLY']],
	[pattern: '/**/favicon.ico', access: ['IS_AUTHENTICATED_FULLY']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]


