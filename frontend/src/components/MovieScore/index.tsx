import MovieStars from "components/MovieStars";
import './styles.css'

type Props = {
    score: number;
    count: number;
}

function MovieScore({ score, count } : Props ) {

    var ratingsLabel = count > 1 ? "Avaliações" : "Avaliação";

    return (
        <div className="dsmovie-score-container">
            <p className="dsmovie-score-value">{score > 0 ? score.toFixed(1) : '-'}</p>
            <MovieStars score={score} />
            <p className="dsmovie-score-count">{count} {ratingsLabel}</p>
        </div>
    );
}

export default MovieScore;