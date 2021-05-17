package org.peng.context.service;

import org.peng.context.base.MovieService;

/**
 * Create by peng on 2021/5/17.
 */
public class DefaultMovieService implements MovieService {
    @Override
    public String getMovieName() {
        return "A Touch of Sin";
    }
}
