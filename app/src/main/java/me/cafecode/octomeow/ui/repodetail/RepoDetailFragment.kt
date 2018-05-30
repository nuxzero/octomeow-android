package me.cafecode.octomeow.ui.repodetail


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.cafecode.octomeow.R
import me.cafecode.repository.model.Repo
import org.parceler.Parcels

class RepoDetailFragment : Fragment() {

    var repo: Repo? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.reppo_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        repo = Parcels.unwrap(arguments?.getParcelable(ARG_REPO))

        Log.d("detail", "$repo")
    }

    companion object {

        private val ARG_REPO = "repo"

        fun newInstance(repo: Repo): RepoDetailFragment {
            val fragment = RepoDetailFragment()
            val args = Bundle()
            args.putParcelable(ARG_REPO, Parcels.wrap(repo))
            fragment.arguments = args
            return fragment
        }
    }
}
