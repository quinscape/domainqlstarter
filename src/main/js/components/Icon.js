import React from "react"
import cx from "classnames"

/**
 * Font-Awesome standard icon.
 *
 * @param props
 * @returns {*}
 */
export default function(props)
{
    const { className } = props;

    return (
        <i className={ cx("fas", className) } />
    )
};
