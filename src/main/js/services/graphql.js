/**
 * GraphQL query service
 *
 * @param params    Parameters
 * @param {String} params.query         query string
 * @param {Object} params.variables     query variables
 *
 * @returns {Promise<any>} Promise resolving to query data
 */
export default function (params) {

    //console.log("QUERY: ", params);

    return fetch(
        window.location.origin + "/graphql",
        {
            method: "post",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(params)
        }
    ).then(response => {
        return response.json();
    });
}
