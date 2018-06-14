import React from "react"
import Loadable from "react-loadable"

export default Loadable({

    loader: () => import('./Lazy'),

    loading: ({ error, timedOut, pastDelay, retry }) => (
        <React.Fragment>
            { error && <p className="text-danger">Error Loading component. <a className="btn" onClick={ retry }>Retry</a> </p> }
            { timedOut && <p className="text-info">Time out, failed to load component. <a className="btn" onClick={ retry }>Retry</a></p> }
            { pastDelay && <p>Loading 'Lazy'...</p> }
        </React.Fragment>
    )
});

