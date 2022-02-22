module.exports = {
  title: 'VuePress 시작!',
  description: 'Hello World',
  themeConfig: {
   head: [
         ['link', { rel: 'icon', href: '/logo.png' }],
         ['link', { rel: 'manifest', href: '/manifest.json' }]
         ]
    nav: [
      {
        text: 'About',
        items: [
           { text: 'About Me', link: '/about/me' },
           { text: 'About Blog', link: '/about/blog' }
        ]
      }
    ]
   plugins: [
	['@vuepress/back-to-top']
	['@vuepress/pwa', {
            serviceWorker: true,
            updatePopup: true}]
	]
  }
}
