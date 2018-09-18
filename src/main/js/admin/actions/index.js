
    // language=GraphQL
export const LIST_USERS_QUERY = `
    query listUsers($offset: Int, $limit: Int)
    {
        listUsers(offset: $offset, limit: $limit) {
            id
            login
            disabled
            created
            lastLogin
            roles
            foos{
                id
                name
            }
        }
    }
`;
