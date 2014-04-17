print "Getting Application Status..."
apps = AdminApp.list().splitlines()
for app in apps:
    # print app
    appObj = AdminControl.completeObjectName(
        'type=Application,name=' + app + ',*')
    if appObj != '':
        appStatus = 'running'
    else:
        appStatus = 'stopped'
    print 'Application:' + app + '=' + appStatus
