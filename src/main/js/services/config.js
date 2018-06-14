
// default config without initConfig() call
let config = {
    contextPath : "",
    authentication: { login : "default", roles: [ "ROLE_DEFAULT"] },
    csrfToken: { }
};

// take only values we have defaults for from the initial data
const filter = Object.keys(config);

export function initConfig(initial)
{
    config = {};

    for (let i = 0; i < filter.length; i++)
    {
        const name = filter[i];
        config[name] = initial[name];
    }
}

/**
 * Config holder service holding everlasting initial view data.
 * @return {*}
 */
export default function()
{
    return config;
}
